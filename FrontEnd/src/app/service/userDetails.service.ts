import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { UserDetailsDTO } from '../UserDetailsDTO.model';
import { Observable } from 'rxjs';

@Injectable()
export class userDetailsService {
  constructor(private http: HttpClient) {}

  checkIfUserExists(username) {
    return this.http.get<UserDetailsDTO>(
      `http://localhost:8082/Users/${username}`
    );
  }

  AddUser(user) {
    return this.http.post(`http://localhost:8082/Users`, user);
  }

  getUser(user): Observable<HttpResponse<any>> {
    return this.http.get<any>(
      `http://localhost:8080/Users/${user.get('userName')}/${user.get(
        'password'
      )}`,
      { observe: 'response' }
    );
  }
  updateUser(user) {
    console.log(user.userName);
    return this.http.post(
      `http://localhost:8082/Users/${user.get('id')}`,
      user
    );
  }
}
