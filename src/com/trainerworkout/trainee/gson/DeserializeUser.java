package com.trainerworkout.trainee.gson;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.trainerworkout.trainee.model.rest.UserModel;

public class DeserializeUser implements JsonDeserializer<UserModel> {
    @Override
    public UserModel deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        JsonElement user = je.getAsJsonObject().get("data");
        return new Gson().fromJson(user, UserModel.class);

    }
}