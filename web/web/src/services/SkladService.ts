import {apiGet} from "../api/apiClient.ts";
import type {SkladDto} from "../models/SkladDto.ts";

export async function dejSklady(){
    return apiGet<SkladDto[]>("sklad");
}
export async function dejSkladPodleId(id : number){
    return apiGet<SkladDto>("sklad" + {id})
}