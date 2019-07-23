package com.ubihacks.synodic.synodic.API;
import com.ubihacks.synodic.synodic.MODEL.Device;
import com.ubihacks.synodic.synodic.MODEL.DriverStatus;
import com.ubihacks.synodic.synodic.MODEL.Position;
import com.ubihacks.synodic.synodic.MODEL.Stop;
import com.ubihacks.synodic.synodic.MODEL.Trip;
import com.ubihacks.synodic.synodic.MODEL.User;

import java.sql.Driver;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by Atiq on 4/10/2018.
 */

public interface Api {

    // login
    @FormUrlEncoded
    @POST("session")
    Call<User> login(@Field("email") String email, @Field("password") String password);

    // Refresh Cookies
    @GET("session")
    Call<User> session(@Query("token") String token);

    // Logout
    @DELETE("session")
    Call<User> logout();

    @GET("devices")
    Call<List<Device>> getDevices();

    @GET("positions")
    Call<List<Position>> getCurrentPositionsForAll();

    //2018-03-01T18:30:00Z   Sample Date formate

    @GET("positions")
    Call<List<Position>> getPastPositions(@Query("deviceId") int id, @Query("from") String from, @Query("to") String to);

    @POST("driverstatus")
    Call<DriverStatus> setDriverStatus(@Body DriverStatus status);

    @GET("driverstatus")
    Call<List<DriverStatus>> getCurrentDriverStatus(@Query("deviceId") int id);

    @GET("driverstatus")
    Call<List<DriverStatus>> getDriverStatus(@Query("deviceId") int id, @Query("from") String from, @Query("to") String to);

    @GET("positions")
    Call<List<Position>> getCurrentPosition(@Query("id") int id);

    @GET("reports/trips")
    Call<List<Trip>> getTrips(@Query("deviceId") int deviceId, @Query("from") String from, @Query("to") String to); //@Query("deviceId") int id, @Query("from") String from, @Query("to") String to);

    @GET("reports/stops")
    Call<List<Stop>> getStops(@Query("from") String from, @Query("to") String to, @Query("deviceId") int id); //@Query("deviceId") int id, @Query("from") String from, @Query("to") String to);
}


