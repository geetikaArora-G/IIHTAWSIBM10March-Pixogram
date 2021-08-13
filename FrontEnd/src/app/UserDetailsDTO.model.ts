export class UserDetailsDTO {
  public id: any;
  public firstName: string;
  public lastName: string;
  public userName: string;
  public email: string;
  public dob: Date;
  public password: string;
  public confirmPassword: string;
  public profilePicture: File;
  constructor(
    id: any,
    firstName: string,
    lastName: string,
    userName: string,
    email: string,
    dob: Date,
    password: string,
    confirmPassword: string,
    profilePicture: File
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.dob = dob;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.profilePicture = profilePicture;
  }
}
