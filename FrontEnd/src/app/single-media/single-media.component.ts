import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MediaDetailsDTO } from '../MediaDetailsDTO.model';
import { RequestBody } from '../RequestBody.model';
import { UploadMediaService } from '../service/upload-media.service';

@Component({
  selector: 'app-single-media',
  templateUrl: './single-media.component.html',
  styleUrls: ['./single-media.component.css']
})
export class SingleMediaComponent implements OnInit {
  media: File;
  userId: any;
  mediaUploaded: false;
  image: any;
  constructor(
    private service: UploadMediaService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.mediaUploaded = this.route.snapshot.params['mediaUploaded'];
    this.route.queryParams.subscribe(params => {
      this.userId = params.userId;
    });
    if (this.userId == undefined) {
      this.userId = this.route.snapshot.params['userId'];
    }
  }
  onFileSelect(event) {
    if (event.target.files.length > 0) {
      this.media = event.target.files[0];
    }
    var reader = new FileReader();
    reader.readAsDataURL(this.media);
    reader.onload = _event => {
      this.image = reader.result;
    };
  }

  uploadMedia(mediaForm: NgForm) {
    var formData: any = new FormData();
    formData.append('mediaDetailsDto[0].title', mediaForm.value.title);
    formData.append(
      'mediaDetailsDto[0].description',
      mediaForm.value.description
    );
    formData.append('mediaDetailsDto[0].tags', mediaForm.value.tags);
    formData.append('mediaDetailsDto[0].media', this.media);

    this.service.addMediaDetails(formData, this.userId).subscribe(
      data => {
        this.router
          .navigate([
            'singleMedia',
            { mediaUploaded: true, userId: this.userId }
          ])
          .then(() => {
            window.location.reload();
          });
      },
      error => {
        console.log(error);
      }
    );
  }
}
