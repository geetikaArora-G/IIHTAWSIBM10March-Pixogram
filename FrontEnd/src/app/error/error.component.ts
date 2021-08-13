import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  userFound = false;
  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.userFound = this.route.snapshot.params['userFound'];
  }
}
