package sapotero.simplereader.retrofit;


import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RssService {

  @GET("oshs/me.json")
  String load(
    @Query("login") String login,
    @Query("auth_token") String token
  );
}
