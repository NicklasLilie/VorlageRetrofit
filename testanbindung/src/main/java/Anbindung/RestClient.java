package Anbindung;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class              RestClient {
    private final String baseUrl;
    private UserService userService;

    public RestClient(String baseUrl) {
        this.baseUrl = baseUrl;
/*
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();
*/

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        userService = restAdapter.create(UserService.class);
    }

    public UserService getUserService() {
        return userService;
    }
}

