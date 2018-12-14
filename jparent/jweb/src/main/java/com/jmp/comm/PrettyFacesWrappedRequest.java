package com.jmp.comm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

public class PrettyFacesWrappedRequest extends HttpServletRequestWrapper
{
    private final String charset = "UTF-8";
    private final String body;
    private final Map<String, String[]> modifiableParameters;
    private Map<String, String[]> allParameters = null;


    public PrettyFacesWrappedRequest(final HttpServletRequest request) throws IOException
    {
        super(request);

        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        body = sb.toString();

        modifiableParameters = new TreeMap<String, String[]>();

        if(StringUtils.isNotBlank(body)){
            Object jsonObj = JSON.parse(body);
            if(jsonObj instanceof JSONArray){
                modifiableParameters.put("data", new String[] {body});
            }else if(jsonObj instanceof JSONObject){
                for (JSONObject.Entry<String, Object> entry : ((JSONObject)jsonObj).entrySet()) {
                    if (StringUtils.isNotBlank(entry.getKey()) && entry.getValue() != null) {
                        if (entry.getValue() != null) {
                            if ((entry.getValue() instanceof JSONObject) || (entry.getValue() instanceof JSONArray)) {
                                modifiableParameters.put(entry.getKey(), new String[]{JSON.toJSONString(entry.getValue(), WriteMapNullValue, WriteNullStringAsEmpty, WriteNullNumberAsZero)});
                            }else{
                                modifiableParameters.put(entry.getKey(), new String[]{entry.getValue().toString()});
                            }
                        }else{
                            modifiableParameters.put(entry.getKey(), null);
                        }
                    }
                }
            }
        }
    }

    /**
     * Create a new request wrapper that will merge additional parameters into
     * the request object without prematurely reading parameters from the
     * original request.
     * 
//     * @param request
//     * @param additionalParams
     */
//    public PrettyFacesWrappedRequest(final HttpServletRequest request,
//                                                    final Map<String, String[]> additionalParams) throws IOException
//    {
//        super(request);
//        modifiableParameters = new TreeMap<String, String[]>();
//        modifiableParameters.putAll(additionalParams);
//    }



    @Override
    public String getParameter(final String name)
    {
        String[] strings = getParameterMap().get(name);
        if (strings != null)
        {
            return strings[0];
        }
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap()
    {
        if (allParameters == null)
        {
            allParameters = new TreeMap<String, String[]>();
            allParameters.putAll(super.getParameterMap());
            allParameters.putAll(modifiableParameters);
        }
        //Return an unmodifiable collection because we need to uphold the interface contract.
        return Collections.unmodifiableMap(allParameters);
    }



    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes(charset));
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @Override
    public Enumeration<String> getParameterNames()
    {
        return Collections.enumeration(getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(final String name)
    {
        return getParameterMap().get(name);
    }


    
}