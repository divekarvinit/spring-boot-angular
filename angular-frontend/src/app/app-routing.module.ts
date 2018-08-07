import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from './heroes/heroes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { UserComponent } from "./user/user.component";
import { LoginComponent } from "./user/login/login.component";
import { SignUpComponent } from "./user/sign-up/sign-up.component";
import { SuggestionComponent } from './home/suggestion/suggestion.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './services/auth.guard';
import { ProfileComponent } from "./home/profile/profile.component";

const routes: Routes = [
  { path: 'heroes', component: HeroesComponent },
  { path: 'dashboard', component: DashboardComponent },
  {
    path: 'home',
    children: [
      { path: 'suggestions', component: SuggestionComponent, canActivate: [AuthGuard] },
      { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
      { path: '', redirectTo: 'suggestions', pathMatch: 'full' }
    ],
    component: HomeComponent
  },
  // {path : '', redirectTo: '/dashboard', pathMatch : 'full'},
  { path: 'detail/:id', component: HeroDetailComponent },
  {
    path: 'signup', component: UserComponent,
    children: [{ path: '', component: SignUpComponent }]
  },
  {
    path: 'login', component: UserComponent,
    children: [{ path: '', component: LoginComponent }]
  },
  {
    path: '', redirectTo: '/login', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
