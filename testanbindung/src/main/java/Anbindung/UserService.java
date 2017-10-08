package Anbindung;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;



public interface UserService {

    @POST("users")
    Call<Void> createAccount(@Body User user);

    @GET("users/{username}")
    Call<User> getUserByUsername(@Path("username" )String name );
}
