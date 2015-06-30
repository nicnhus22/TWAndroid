package com.trainerworkout.trainee.helper;

import retrofit.RequestInterceptor;
import android.util.Base64;

import com.trainerworkout.trainee.model.rest.UserModel;

/**
 * Interceptor used to authorize requests.
 */
public class ApiRequestInterceptor implements RequestInterceptor {

    private String thing;

    @Override
    public void intercept(RequestFacade requestFacade) {
        final String authorizationValue = encodeCredentialsForBasicAuthorization();
        requestFacade.addHeader("Authorization", authorizationValue);
    }

    private String encodeCredentialsForBasicAuthorization() {
        final String userAndPassword = thing;
        return "Basic " + Base64.encodeToString(userAndPassword.getBytes(), Base64.NO_WRAP);
    }
    
    public void setThing(String thing){
    	this.thing = thing;
    }
}