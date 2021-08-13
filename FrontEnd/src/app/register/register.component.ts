import { Component, OnInit, Injectable, Inject } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { userDetailsService } from '../service/userDetails.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  profilePicture: File;
  userAlreadyExists: String = 'Check User Availibitlity';
  constructor(private service: userDetailsService, private router: Router) {}

  ngOnInit(): void {}

  //To Retrive Picture Selected By User
  onFileSelect(event) {
    if (event.target.files.length > 0) {
      this.profilePicture = event.target.files[0];
    }
  }

  OnSubmit(register: NgForm, event) {
    if (event.submitter.name == 'submit') {
      this.registerUser(register);
    }
    if (event.submitter.name == 'checkUserExistence') {
      this.checkIfUserExists(register);
    }
  }

  //Method to Send User Details to User Registration Service
  registerUser(register: NgForm) {
    var formData: any = new FormData();
    formData.append('firstName', register.value.firstName);
    formData.append('lastName', register.value.lastName);
    formData.append('userName', register.value.userName);
    formData.append('email', register.value.email);
    formData.append('dob', register.value.dob);
    formData.append('password', register.value.password);
    formData.append('confirmPassword', register.value.confirmPassword);
    formData.append('profilePicture', this.profilePicture);
    if (register.invalid) {
      return;
    }
    this.service.checkIfUserExists(register.value.userName).subscribe(
      data => {
        this.router.navigate(['register']);
      },
      error => {
        this.service.AddUser(formData).subscribe(
          data => {
            this.router.navigate([
              'welcome',
              { userName: register.value.userName, isRegistered: true }
            ]);
          },
          error => {
            this.router.navigate(['error']);
          }
        );
      }
    );
  }

  checkIfUserExists(register: NgForm) {
    var formData: any = new FormData();

    this.service.checkIfUserExists(register.value.userName).subscribe(
      data => {
        this.userAlreadyExists = 'User Already Exists';
      },
      error => {
        this.userAlreadyExists = 'UserName is Available';
      }
    );
  }
}
