package com.polotechnologies.dagger2practice.di.modules

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.polotechnologies.dagger2practice.R
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.white_background)
            .error(R.drawable.white_background)
    }

    @Provides
    fun providesRequestManager(application: Application, requestOptions: RequestOptions)
            : RequestManager {

        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Provides
    fun providesLogo(application: Application): Drawable{
        return ContextCompat.getDrawable(application, R.drawable.logo)!!
    }
}