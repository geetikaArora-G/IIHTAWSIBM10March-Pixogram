import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloComponent } from './hello.component';
import { userDetailsService } from './service/userDetails.service';
import { HttpClientModule } from '@angular/common/http';
import { RouteGuardService } from './service/route-guard.service';
import { HeaderComponent } from './header/header.component';
import { LogoutComponent } from './logout/logout.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { UpdateComponent } from './update/update.component';
import { MainComponent } from './main/main.component';
import { SuccessComponent } from './success/success.component';
import { ErrorComponent } from './error/error.component';
import { MyMediaComponent } from './my-media/my-media.component';
import { SingleMediaComponent } from './single-media/single-media.component';
import { MultipleMediaComponent } from './multiple-media/multiple-media.component';
import { UploadMediaService } from './service/upload-media.service';
import { UploadMediaComponent } from './upload-media/upload-media.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptorService } from './service/http-interceptor.service';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [
    AppComponent,
    HelloComponent,
    HeaderComponent,
    LogoutComponent,
    WelcomeComponent,
    UpdateComponent,
    MainComponent,
    SuccessComponent,
    routingComponents,
    MyMediaComponent,
    UploadMediaComponent,
    SingleMediaComponent,
    MultipleMediaComponent,
    ErrorComponent
  ],
  providers: [
    userDetailsService,
    RouteGuardService,
    UploadMediaService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
