import {apiGet} from "../api/apiClient.ts";
import type {SkladDto} from "../models/SkladDto.ts";

export function dejSklady(){
    return apiGet<SkladDto[]>("sklad");
}