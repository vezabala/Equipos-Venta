import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IEquipo, Equipo } from 'app/shared/model/equipo.model';
import { EquipoService } from './equipo.service';

@Component({
  selector: 'jhi-equipo-update',
  templateUrl: './equipo-update.component.html'
})
export class EquipoUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    activoFijo: [null, [Validators.required, Validators.maxLength(70)]],
    marca: [null, [Validators.required, Validators.maxLength(70)]],
    procesador: [null, [Validators.required, Validators.maxLength(200)]],
    office: [null, [Validators.required, Validators.maxLength(70)]],
    sistemaOperativo: [null, [Validators.required, Validators.maxLength(70)]],
    discoDuro: [null, [Validators.required, Validators.maxLength(70)]],
    ram: [null, [Validators.required, Validators.maxLength(70)]],
    observaciones: [null, [Validators.maxLength(200)]]
  });

  constructor(protected equipoService: EquipoService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ equipo }) => {
      this.updateForm(equipo);
    });
  }

  updateForm(equipo: IEquipo): void {
    this.editForm.patchValue({
      id: equipo.id,
      activoFijo: equipo.activoFijo,
      marca: equipo.marca,
      procesador: equipo.procesador,
      office: equipo.office,
      sistemaOperativo: equipo.sistemaOperativo,
      discoDuro: equipo.discoDuro,
      ram: equipo.ram,
      observaciones: equipo.observaciones
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const equipo = this.createFromForm();
    if (equipo.id !== undefined) {
      this.subscribeToSaveResponse(this.equipoService.update(equipo));
    } else {
      this.subscribeToSaveResponse(this.equipoService.create(equipo));
    }
  }

  private createFromForm(): IEquipo {
    return {
      ...new Equipo(),
      id: this.editForm.get(['id'])!.value,
      activoFijo: this.editForm.get(['activoFijo'])!.value,
      marca: this.editForm.get(['marca'])!.value,
      procesador: this.editForm.get(['procesador'])!.value,
      office: this.editForm.get(['office'])!.value,
      sistemaOperativo: this.editForm.get(['sistemaOperativo'])!.value,
      discoDuro: this.editForm.get(['discoDuro'])!.value,
      ram: this.editForm.get(['ram'])!.value,
      observaciones: this.editForm.get(['observaciones'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IEquipo>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
