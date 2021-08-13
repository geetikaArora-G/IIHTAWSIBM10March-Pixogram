import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormGroup,
  NgForm,
  Validators
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UploadMediaService } from '../service/upload-media.service';

@Component({
  selector: 'app-multiple-media',
  templateUrl: './multiple-media.component.html',
  styleUrls: ['./multiple-media.component.css']
})
export class MultipleMediaComponent implements OnInit {
  media: File;
  media2: File;
  userId: any;
  mediaUploaded: false;
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
  }
  onFileSelect2(event) {
    if (event.target.files.length > 0) {
      this.media2 = event.target.files[0];
    }
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
    formData.append('mediaDetailsDto[1].title', mediaForm.value.title2);
    formData.append(
      'mediaDetailsDto[1].description',
      mediaForm.value.description2
    );
    formData.append('mediaDetailsDto[1].tags', mediaForm.value.tags2);
    formData.append('mediaDetailsDto[1].media', this.media2);

    this.service.addMediaDetails(formData, this.userId).subscribe(
      data => {
        this.router
          .navigate([
            'multipleMedia',
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
