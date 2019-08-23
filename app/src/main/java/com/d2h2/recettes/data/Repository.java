package com.d2h2.recettes.data;

import android.app.DownloadManager;
import android.widget.ImageView;

import com.d2h2.recettes.data.Repo.CommentRepo;
import com.d2h2.recettes.data.Repo.CommentsRepo;
import com.d2h2.recettes.data.Repo.ImgRepo;
import com.d2h2.recettes.data.Repo.IngredientRepo;
import com.d2h2.recettes.data.Repo.IngredientsRepo;
import com.d2h2.recettes.data.Repo.RecipeRepo;
import com.d2h2.recettes.data.Repo.RecipesRepo;
import com.d2h2.recettes.data.Repo.UserRepo;
import com.d2h2.recettes.data.model.Ingredient;

import java.util.List;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface  Repository {
    @GET("/api/recipes")
    Single<RecipesRepo> getRepositories();

    @GET("api/recipes/{id}")
    Single<RecipeRepo> getRecipe(@Path("id") String id);

    @GET("api/search/ingredients/{recipe_id}")
    Single<IngredientsRepo> getIngredientList(@Path("recipe_id") String id);

    @GET("api/ingredients/{id}")
    Single<IngredientRepo> getIngredient(@Path("id") String id);

    @GET("api/search/comments/{recipe_id}")
    Single<CommentsRepo> getComments(@Path("recipe_id") String id);

//    @POST("api/search/recipes")
//    Single<IngredientsRepo> getIngredients(@Body IngredientRequest ingredientRequest);

    @POST("/api/comments")
    @FormUrlEncoded
    Single<CommentRepo> postComment(@Field("content") String content,
                                    @Field("ownerId") String ownerId,
                                    @Field("recipeId") String recipeId);

    @POST("/api/recipes")
    @FormUrlEncoded
    Single<RecipeRepo> postRecipes(@Field("name") String name,
                                   @Field("description") String description,
                                   @Field("directions") List<String> directions,
                                   @Field("ownerId") String ownerId,
                                   @Field("images") List<String> images);

    @POST("/api/users")
    @FormUrlEncoded
    Single<UserRepo> postUsers(@Field("userId") String id,
                                 @Field("name") String name,
                                 @Field("email") String email,
                                 @Field("avatar") String linkImg);

    @POST("/upload")
    Single<ImgRepo> postImage(@Body RequestBody requestBody);

//    @POST("/api/search/recipes")
//    @FormUrlEncoded
//    Single<RecipeRepo> postRecipes(@Field("name") String name;
}
