package com.trainerworkout.trainee.gson;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;

public class DeserializeWorkoutHolder implements JsonDeserializer<List<WorkoutHolderModel>> {
    @Override
    public List<WorkoutHolderModel> deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        JsonElement workoutHolder = je.getAsJsonObject().get("data");
        Type listType = new TypeToken<List<WorkoutHolderModel>>(){}.getType();
        return new Gson().fromJson(workoutHolder, listType);
    }
}