# Hoe kunnen we verschillende externe vervoersservices (zoals Google Maps of een veerdienst API) integreren zonder afhankelijk te worden van hun specifieke implementaties?


## Welke componenten hebben we nodig 
* BouwsteenController
* BouwsteenService
* BouwsteemRepository
* VervoerAdapter

# Verantwoordelijkheden
| Component|Verantwoordelijkheid|Topepassing Principle|
| ----------- | ----------- |----------|
| BouwsteenController | Ontvangt Http verzoeken, valideerd de invoer en stuurt de aanvraag door naar de service laag |Seperation of concerns|
| BouwsteenService | Verwerkt de buisneslogica en doet de interactie met de Bouwsteenrepository |Single responsibility principle|
| BouwsteemRepository |Interactie met de database en VervoerAdapter  |Encapsulate what varies|
| VervoerAdapter |Interactie met de gekozen vervoersapi's  |Cohision|
