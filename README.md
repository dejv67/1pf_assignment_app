# Kurzovní lístek – demonstrační aplikace

Jednoduchá fullstack aplikace pro zobrazení kurzovních lístků s možností načítání dat buď z externího API České spořitelny nebo z interní databáze.

---

## 🧩 Struktura aplikace

### 🖥️ Frontend (React + Vite)
- React + Vite
- Fetch dat z backendu (`/api/rates`)
- Zobrazuje seznam kurzovnch lístků a detail zvoleného lístku
- Přepínání mezi načítáním z databáze nebo externího API možno skrze konstantu _**useDb**_ (true/false) v _App.jsx_ v modulu _frontend_

### ⚙️ Backend (Spring Boot)
- REST API na adrese `http://localhost:8080/api/rates`
- Data lze načíst buď z:
  - interní MySQL databáze (`usedb=true`)
  - externího API České spořitelny (`usedb=false`)
- Obsahuje mapování mezi DTO a entitami a možnost načítení a uložení dat do DB (MySQL)

---

##  Spuštění aplikace

#### ✅ Předpoklady a nastavení:
- **Java**: 21
- **Spring Boot**: 3.5.3
- **MySQL**: 8.4
- **Node.js**: 22.9.0
- **npm**: 11.4.2
- **Gradle**


- MySQL běží v dockeru na portu `3306`, přístupové údaje a další nastavení DB v application.properties
- CORS je globálně povolen pro http://localhost:5173, kde také běží FE (konfigurace ve _WebConfig_)
- BE běží na http://localhost:8080/api/rates 
  - GET /api/rates?usedb={true|false}


#### ▶️ Spuštění:
1) Je potřeba spustit DB skrz _docker-compose.yml_, například příkazem `docker-compose up -d` z terminálu v adresáři, ve kterém se soubor nachází
2) Spuštění **BE** (Springbootu) například skrze _BackendApplication.java_
3) Spuštění **FE** z terminálu v adresáři **frontend** příkazem `npm run dev`

