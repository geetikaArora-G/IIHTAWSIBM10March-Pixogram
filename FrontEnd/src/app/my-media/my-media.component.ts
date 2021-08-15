import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { UploadMediaService } from '../service/upload-media.service';

@Component({
  selector: 'app-my-media',
  templateUrl: './my-media.component.html',
  styleUrls: ['./my-media.component.css']
})
export class MyMediaComponent implements OnInit {
  userId: any;
  images: any = [];
  constructor(
    private service: UploadMediaService,
    private router: Router,
    private route: ActivatedRoute,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.userId = params.userId;
    });

    this.service.getMediaDetails(this.userId).subscribe(data => {
      this.images = data;
    });
  }
  public getSantizeUrl(url: string) {
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }
}
