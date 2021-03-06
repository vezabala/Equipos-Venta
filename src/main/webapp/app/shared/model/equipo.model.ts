import { IUsuario } from 'app/shared/model/usuario.model';
import { Tipo } from 'app/shared/model/enumerations/tipo.model';

export interface IEquipo {
  id?: number;
  activoFijo?: string;
  marca?: string;
  procesador?: string;
  office?: string;
  sistemaOperativo?: string;
  discoDuro?: string;
  ram?: string;
  observaciones?: string;
  imagenContentType?: string;
  imagen?: any;
  tipo?: Tipo;
  usuarios?: IUsuario[];
}

export class Equipo implements IEquipo {
  constructor(
    public id?: number,
    public activoFijo?: string,
    public marca?: string,
    public procesador?: string,
    public office?: string,
    public sistemaOperativo?: string,
    public discoDuro?: string,
    public ram?: string,
    public observaciones?: string,
    public imagenContentType?: string,
    public imagen?: any,
    public tipo?: Tipo,
    public usuarios?: IUsuario[]
  ) {}
}
