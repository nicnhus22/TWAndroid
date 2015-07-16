package com.trainerworkout.trainee.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.trainerworkout.trainee.model.rest.WorkoutHolderModel;
import com.trainerworkout.trainee.model.rest.WorkoutsExercisesModel;

public class DeserializeWorkoutHolder implements JsonDeserializer<List<WorkoutHolderModel>> {
    @Override
    public List<WorkoutHolderModel> deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        JsonElement workoutHolder = je.getAsJsonObject().get("data");
        Type listType = new TypeToken<List<WorkoutHolderModel>>(){}.getType();
        
        List<WorkoutHolderModel> workoutHolders = new Gson().fromJson(workoutHolder, listType);
        
        JsonArray workouts = workoutHolder.getAsJsonArray();
        int index = 0;
        for(JsonElement workout: workouts){
        	
        	List<WorkoutsExercisesModel> workoutExercises = new ArrayList<WorkoutsExercisesModel>();
        	JsonElement exercises = workout.getAsJsonObject().get("exercises");
        	
        	
        	for(JsonElement exercise: exercises.getAsJsonArray()){
            	WorkoutsExercisesModel exe = new Gson().fromJson(exercise.getAsJsonObject().get("exercise"), WorkoutsExercisesModel.class);
            	workoutExercises.add(exe);
        	}
        	workoutHolders.get(index).setExercises(workoutExercises);
        	
        	index++;
        }
        
        return workoutHolders;
    }
}