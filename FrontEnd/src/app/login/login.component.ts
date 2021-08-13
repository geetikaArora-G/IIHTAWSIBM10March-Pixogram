import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { userDetailsService } from '../service/userDetails.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userNotFound = false;
  constructor(
    private service: userDetailsService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.userNotFound = this.route.snapshot.params['userNotFound'];
  }

  //Method to Login User
  loginUser(login: NgForm) {
    var formData: any = new FormData();

    formData.append('userName', login.value.userName);
    formData.append('password', login.value.password);

    if (login.invalid) {
      return;
    }

    this.service.getUser(formData).subscribe(
      (data: HttpResponse<any>) => {
        var token = data.headers.get('Authorization');
        sessionStorage.setItem('token', token);
        this.router.navigate([
          'welcome',
          {
            userName: login.value.userName,
            isLoggedIn: true,
            userId: data.body.id
          }
        ]);
      },
      error => {
        this.router.navigate(['login', { userNotFound: true }]).then(() => {
          window.location.reload();
        });
      }
    );
  }
}
