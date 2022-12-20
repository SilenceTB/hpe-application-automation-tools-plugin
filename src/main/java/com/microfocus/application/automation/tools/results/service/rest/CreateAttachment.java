/*
 * Certain versions of software and/or documents ("Material") accessible here may contain branding from
 * Hewlett-Packard Company (now HP Inc.) and Hewlett Packard Enterprise Company.  As of September 1, 2017,
 * the Material is now offered by Micro Focus, a separately owned and operated company.  Any reference to the HP
 * and Hewlett Packard Enterprise/HPE marks is historical in nature, and the HP and Hewlett Packard Enterprise/HPE
 * marks are the property of their respective owners.
 * __________________________________________________________________
 * MIT License
 *
 * (c) Copyright 2012-2021 Micro Focus or one of its affiliates.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * ___________________________________________________________________
 */

package com.microfocus.application.automation.tools.results.service.rest;

import com.microfocus.application.automation.tools.sse.sdk.Client;
import com.microfocus.application.automation.tools.sse.sdk.ResourceAccessLevel;
import com.microfocus.application.automation.tools.sse.sdk.Response;
import com.microfocus.application.automation.tools.sse.sdk.request.PostRequest;
import com.microfocus.adm.performancecenter.plugins.common.rest.RESTConstants;

import java.util.HashMap;
import java.util.Map;

public class CreateAttachment extends PostRequest {

    private Client client;
    private String testsetId;
    private String fileName;
    private byte[] filecontent;
    private String entityCollectionName;

    private static final String CONTENT_TYPE = "application/octet-stream";

    public CreateAttachment(String entityCollectionName, Client client, String id, String fileName, byte[] filecontent) {
        super(client, "");
        this.entityCollectionName = entityCollectionName;
        this.client = client;
        this.testsetId = id;
        this.fileName = fileName;
        this.filecontent = filecontent;
    }

    @Override
    protected Map<String, String> getHeaders() {
        Map<String, String> ret = new HashMap<String, String>();
        ret.put(RESTConstants.CONTENT_TYPE, CONTENT_TYPE + ";");
        ret.put("Slug", fileName);
        ret.put("X-XSRF-TOKEN", client.getXsrfTokenValue());
        return ret;
    }

    @Override
    protected String getSuffix() {
        StringBuilder builder = new StringBuilder();
        builder.append(entityCollectionName).append("/").append(testsetId).append("/attachments");
        return builder.toString();
    }

    @Override
    public Response perform() {
        return client.httpPost(
                getUrl(),
                getDataBytes(),
                getHeaders(),
                ResourceAccessLevel.PROTECTED);
    }

    private byte[] getDataBytes() {
        return filecontent;
    }
}