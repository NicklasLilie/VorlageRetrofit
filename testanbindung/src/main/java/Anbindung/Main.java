package Anbindung;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main {

    public static void main (String args[]){
        RestClient restclient = new RestClient("null");
                UserService userService = restclient.getUserService();
        Call<User> lilly = userService.getUserByUsername("Lilly");
        lilly.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.body());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("das war wohl nix");

            }
        });
        User user = new User();
        user.setUsername("Urmel");
        user.setEmailadress("UrmelkamausdemEI@web.de");
        user.setFirstname("Weißichnicht");
        user.setLastname("Honulululu");
        Call<Void> accountcall = userService.createAccount(user);
    accountcall.enqueue(new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            System.out.println("erstellt");
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            System.out.println("nicht erstellt");

        }
    });
    }

}
