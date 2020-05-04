import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UsersService} from '../../../services/users.service';
import {User} from '../../../model/user.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  form: FormGroup;

  constructor(
    private usersService: UsersService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, [Validators.required, Validators.minLength(6)]),
      name: new FormControl(null, [Validators.required]),
      agree: new FormControl(false, [Validators.requiredTrue]),
    });
  }

  onSubmit() {

    const {email, password, login, role} = this.form.value;

    this.usersService.getUserByEmail(email)
      .subscribe(
        (user: User) => {
          if (user.email === email) {
            this.form.controls.email.setErrors({checkEmail: true});
          } else {
            const customer = new User(email, password, login, role);
            this.usersService.createNewUser(customer)
              .subscribe(() => {
                this.router.navigate(['auth/login'],
                  {
                    queryParams: {
                      nowCanLogin: true
                    }
                  }
                );
              });
          }
        });
  }
}
