package com.leeseojune.awss3.service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class AWS4SignerBase {

    public static final String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";

    public static final String TERMINATOR = "aws4_request";

    public static final String ISO8601BasicFormat = "yyyyMMdd'T'HHmmss'Z'";
    public static final String DateStringFormat = "yyyyMMdd";

    protected URL endpointUrl;
    protected String httpMethod;
    protected String serviceName;
    protected String regionName;

    protected final SimpleDateFormat dateTimeFormat;
    protected final SimpleDateFormat dateStampFormat;

    public AWS4SignerBase(URL endpointUrl, String httpMethod,
                          String serviceName, String regionName) {
        this.endpointUrl = endpointUrl;
        this.httpMethod = httpMethod;
        this.serviceName = serviceName;
        this.regionName = regionName;

        dateTimeFormat = new SimpleDateFormat(ISO8601BasicFormat);
        dateTimeFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
        dateStampFormat = new SimpleDateFormat(DateStringFormat);
        dateStampFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
    }

}
