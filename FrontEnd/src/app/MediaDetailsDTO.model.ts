export class MediaDetailsDTO {
  public title: string;
  public description: string;
  public tags: string;
  public media: File;
  public mediaUrl: string;
  public mediaType: string;
  constructor(
    title: string,
    description: string,
    tags: string,
    media: File,
    mediaUrl: string,
    mediaType: string
  ) {
    this.title = title;
    this.description = description;
    this.tags = tags;
    this.media = media;
    this.mediaUrl = mediaUrl;
    this.mediaType = mediaType;
  }
}
