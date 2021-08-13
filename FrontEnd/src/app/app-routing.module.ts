import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { UpdateComponent } from './update/update.component';
import { MainComponent } from './main/main.component';
import { SuccessComponent } from './success/success.component';
import { MyMediaComponent } from './my-media/my-media.component';
import { SingleMediaComponent } from './single-media/single-media.component';
import { MultipleMediaComponent } from './multiple-media/multiple-media.component';
import { UploadMediaComponent } from './upload-media/upload-media.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'update', component: UpdateComponent },
  { path: 'success', component: SuccessComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'myMedia', component: MyMediaComponent },
  { path: 'uploadMedia', component: UploadMediaComponent },
  { path: 'singleMedia', component: SingleMediaComponent },
  { path: 'multipleMedia', component: MultipleMediaComponent },
  { path: 'error', component: ErrorComponent },
  { path: '**', component: ErrorComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [LoginComponent, RegisterComponent];
