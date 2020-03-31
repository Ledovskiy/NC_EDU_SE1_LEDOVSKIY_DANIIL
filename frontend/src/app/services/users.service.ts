import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";



import {User} from "../model/user.model";

@Injectable ()

export class UsersService {

  constructor(private http: HttpClient) { }

  getUserByEmail (email: string): Observable<User> {
    return this.http.get<User>(`http://localhost:3000/users/?email=${email}`)
  }

  createNewUser (user: User): Observable<User> {
    return this.http.post<User>('http://localhost:3000/users', user);
  }
}
