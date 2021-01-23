import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IEquipo, Equipo } from 'app/shared/model/equipo.model';
import { EquipoService } from './equipo.service';
import { EquipoComponent } from './equipo.component';
import { EquipoDetailComponent } from './equipo-detail.component';
import { EquipoUpdateComponent } from './equipo-update.component';

@Injectable({ providedIn: 'root' })
export class EquipoResolve implements Resolve<IEquipo> {
  constructor(private service: EquipoService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IEquipo> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((equipo: HttpResponse<Equipo>) => {
          if (equipo.body) {
            return of(equipo.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Equipo());
  }
}

export const equipoRoute: Routes = [
  {
    path: '',
    component: EquipoComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'equiposVentaApp.equipo.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: EquipoDetailComponent,
    resolve: {
      equipo: EquipoResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'equiposVentaApp.equipo.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: EquipoUpdateComponent,
    resolve: {
      equipo: EquipoResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'equiposVentaApp.equipo.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: EquipoUpdateComponent,
    resolve: {
      equipo: EquipoResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'equiposVentaApp.equipo.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
