import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class UploadMediaService {
  constructor(private http: HttpClient) {}

  addMediaDetails(media, userId) {
    return this.http.post(
      `http://localhost:8088/Media/UploadMedia/${userId}`,
      media
    );
  }
}
