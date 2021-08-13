import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { userDetailsService } from '../service/userDetails.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  userId: any;
  constructor(
    private service: userDetailsService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.userId = params.userId;
    });
  }

  //Method to Login User
  updateUser(update: NgForm) {
    var formData: any = new FormData();
    console.log(this.userId);
    formData.append('userName', update.value.userName);
    formData.append('id', this.userId);
    formData.append('email', update.value.email);
    formData.append('password', update.value.password);
    formData.append('confirmPassword', update.value.confirmPassword);

    if (update.invalid) {
      return;
    }

    this.service.updateUser(formData).subscribe(
      data => {
        this.router.navigate(['welcome', { isUpdated: true }]);
      },
      error => {
        this.router.navigate(['error']);
      }
    );
  }
}
