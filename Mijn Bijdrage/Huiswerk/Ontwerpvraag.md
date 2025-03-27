# Hoe kunnen we verschillende externe vervoersservices (zoals Google Maps of een veerdienst API) integreren zonder afhankelijk te worden van hun specifieke implementaties?


## Welke componenten hebben we nodig 
* BouwsteenController
* BouwsteenService
* BouwsteemRepository
* MapApi

# Verantwoordelijkheden
| Component           | Verantwoordelijkheid                                                                         | Toepassing Principle            |
|---------------------|----------------------------------------------------------------------------------------------|---------------------------------|
| BouwsteenController | Ontvangt Http verzoeken, valideerd de invoer en stuurt de aanvraag door naar de service laag | Seperation of concerns          |
| BouwsteenService    | Verwerkt de businesslogica en doet de interactie met de Bouwsteenrepository                  | Single responsibility principle |
| BouwsteemRepository | Interactie met de database en VervoerAdapter                                                 | Encapsulate what varies         |
| MapAdapter          | Interactie met de gekozen Mapapi's                                                           | Cohision                        |

# Interfaces
 * Vervoersadapter

```java
 Route getRoute(Location start, Location end, TransportMode mode);
List<TransportOption> getAvailableTransportOptions(Location start, Location end);

```

# Volgorde
De volgorde van het aanroepen van componenten is: Controller -> Service-> Repository-> Adapter-> API

```plantuml
@startuml
actor reiziger
participant "BouwsteenController" as Controller
participant "BouwsteenService" as Service
participant "BouwsteenRepository" as Repository
participant "MapApi" as "MapApi"
participant "Externe Api's" as API

reiziger -> Controller: Verzoek route ophalen
Controller -> Service: Verwerk route-aanvraag
Service -> Repository: Haal de beschikbare transportopties ophalen
Repository -> VervoerAdapter: Roep externe api aan

opt Externe API succesvol
    VervoerAdapter -> API: Vraag routegegevens op
    API -> VervoerAdapter: Geeft Routegegevens terug
    VervoerAdapter-> Repository: Geef route terug
    Repository-> Service: Geef route terug
    Service-> Controller: Geef route terug
    Controller-> reiziger: Toon route op UI
end

opt Externe API Faalt
    VervoerAdapter -> API: Vraag routegegevens op
    API -> VervoerAdapter: Fout Api is niet bereikbaar
    VervoerAdapter-> Repository: Geef foutmelding terug
    Repository-> Service: Geef foutmelding terug
    Service-> Controller: Geef foutmelding terug
    Controller-> reiziger: Toon de foutmelding op de UI: "Route informatie is niet beschikbaar"
end
@enduml
```


# Opdelen
De Controller blijft gewoon de controller.
De service blijft gewoon de service
De repository blijft de repository
De adapter blijft de adapter







