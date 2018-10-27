package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.http.HttpRequester;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.parsers.JsonParser;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class HttpApplicationRepository implements ApplicationRepository {

    private final HttpRequester mHttpRequester;
    private final JsonParser<Application> mApplicationJsonParser;
    private final String mBaseApplicationUrl;
    private final String mIdUrl;
    private final String mNameUrl;
    private final String mDateUrl;
    private final JsonParser<User> mUserJsonParser;

    public HttpApplicationRepository(HttpRequester httpRequester, JsonParser<Application> jsonParser,
                                     JsonParser<User> userJsonParser, String serverUrl) {
        mHttpRequester = httpRequester;
        mApplicationJsonParser = jsonParser;
        mUserJsonParser = userJsonParser;
        mBaseApplicationUrl = serverUrl;
        mIdUrl = serverUrl + "/id";
        mNameUrl = serverUrl + "/name";
        mDateUrl = serverUrl + "/date";
    }

    @Override
    public List<Application> getAllByUserEmailOrderById(String email) throws IOException {
        String url = mBaseApplicationUrl + "/" + email;
        String responseBody = mHttpRequester.get(url);

        return mApplicationJsonParser.fromJsonArray(responseBody);
    }

    @Override
    public List<Application> getAllByStatus(ApplicationStatus status) throws IOException {
        String requestBody = status.toString();
        String url = mBaseApplicationUrl + "/" + requestBody;
        String responseBody = mHttpRequester.get(url);

        return mApplicationJsonParser.fromJsonArray(responseBody);
    }

    @Override
    public List<Application> getAllByDateOfSubmission(Date date) throws IOException {
        String responseBody = mHttpRequester.get(mDateUrl);

        return mApplicationJsonParser.fromJsonArray(responseBody);
    }

    @Override
    public List<Application> getAllByPersonName(String name) throws IOException {
        String responseBody = mHttpRequester.get(mNameUrl);

        return mApplicationJsonParser.fromJsonArray(responseBody);
    }

    @Override
    public List<Application> getById(Long id) throws IOException {
        String url = mBaseApplicationUrl + "/" + id;
        String responseBody = mHttpRequester.get(url);

        return mApplicationJsonParser.fromJsonArray(responseBody);
    }

    @Override
    public Application create(Application application) throws IOException {
        String requestBody = mApplicationJsonParser.toJson(application);
        String responseBody = mHttpRequester.post(mBaseApplicationUrl, requestBody);

        return mApplicationJsonParser.fromJson(responseBody);
    }
}
