package com.trainerworkout.trainee.gson;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.trainerworkout.trainee.model.rest.ExercisesModel;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutModel;

public class DeserializeExercises implements JsonDeserializer<List<ExercisesModel>> {
    @Override
    public List<ExercisesModel> deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        JsonElement exercises = je.getAsJsonObject().get("exercises");
        Type listType = new TypeToken<List<ExercisesModel>>(){}.getType();
                
        return new Gson().fromJson(exercises, listType);
    }
}