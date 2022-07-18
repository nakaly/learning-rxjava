package learning.rxjava;

import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofit;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class FlatMapTest {

    public static void main(String... args) {
        Retrofit retrofit  = ArmeriaRetrofit
                .builder("http://example.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        TestEndpoint testEndpoint =  retrofit.create(TestEndpoint.class);

        Maybe<Integer> transformed = testEndpoint.get()
//                .flatMap(responseBody -> {
//                    System.out.println(responseBody.contentType());
//                    return testEndpoint.get();
//                })
                .flatMap(responseBody -> {
                    testEndpoint.get();
                    return Maybe.just(responseBody.contentType().toString().length());
                });

        transformed.blockingGet();
    }




}

interface TestEndpoint {
    @GET("/")
    Maybe<ResponseBody> get();
}