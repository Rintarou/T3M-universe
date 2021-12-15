import { UniverseService } from './../../services/universe.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-universe',
  templateUrl: './universe.component.html',
  styleUrls: ['./universe.component.css'],
})
export class UniverseComponent implements OnInit {
  @Input('id') id: number = -1;

  data: any = {};

  constructor(
    private universeService: UniverseService,
    private router: Router
  ) {}

  reload(id: number) {
    this.id = id;
    this.load();
  }

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.universeService.byId(this.id).subscribe({
      next: (d) => (this.data = d),
      error: (e) => console.log(e),
      complete: () => console.info('universe retrieved'),
    });
  }

  seeUniverse() {
    sessionStorage.setItem('universe_id', this.data.id);
    this.router.navigate(['/dashboard']);
  }

  get owner(): string {
    for (let uu of this.data.userUniverses) {
      if (uu.accessRight == 'owner') {
        return uu.id.user.login;
      }
    }
    return '';
  }
}
