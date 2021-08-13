import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  userName = '';
  isRegistered = false;
  isLoggedIn = false;
  userId: any;
  isUpdated = false;
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.userName = this.route.snapshot.params['userName'];
    this.isRegistered = this.route.snapshot.params['isRegistered'];
    this.isLoggedIn = this.route.snapshot.params['isLoggedIn'];
    this.isUpdated = this.route.snapshot.params['isUpdated'];
    this.userId = this.route.snapshot.params['userId'];
  }
}
