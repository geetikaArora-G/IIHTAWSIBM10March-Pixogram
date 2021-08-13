import { MediaDetailsDTO } from './MediaDetailsDTO.model';

export class RequestBody {
  public mediaDetailsDto: MediaDetailsDTO[];

  constructor(mediaDetailsDto: MediaDetailsDTO[]) {
    this.mediaDetailsDto = mediaDetailsDto;
  }
}
