import { Medication } from './medication';
import { Medicationplan } from './medicationplan';

export class Medicationperplan {

    id_med_per_plan: number;
    medicationplan: Medicationplan;
    medication: Medication;

    constructor(medication: Medication){
        this.medication = medication;
    }

}
