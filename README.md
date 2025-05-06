# android_iartes_2025
Aulas do IARTES

## Sumário
- [Links das aulas](#links-das-aulas)
- [Slides](#slides)
- [Códigos](#códigos)
  - [Aula 1 - HelloToast](Códigos/HelloToast)
- [Projetos](#projetos)
- [Plano de Ensino (PDF)](Plano_de_Ensino_IArTES.pdf)
- [Referências](#referências)
- [Informações Úteis](#informações-úteis)

## Links das aulas
- Aula 1: https://docs.google.com/presentation/d/1PtxupZDeqwAlO274scae-budqBxX8szIH8lIcN-VfWA/edit?usp=sharing
- Aula 2: https://docs.google.com/presentation/d/1or6DQXPNds-D4IHcGofPdvP0haoaypUwLDr20oFhLsM/edit?usp=sharing
- Aula 3 - https://docs.google.com/presentation/d/1UfRzhtgxeeC373BgnsJ3ZMzt0TwqJ0cu1Mv6FBwMr7w/edit?usp=sharing
- Aula 4 - https://docs.google.com/presentation/d/1Cbgb0PZ60-OCB1bn24b1RPvDhjl-RNbSHMxZIl8EnLo/edit?usp=sharing
- Aula 5 - https://docs.google.com/presentation/d/103XSlcC_FtIKZtY40U-eRatByGAsfiCNONxYdOnpJTc/edit?usp=sharing
- Aula 6 - Extra - https://docs.google.com/presentation/d/1q9_WE1QbWSX6jTCYJYB9k06QumXRupDn_ScyC55u2uo/edit?usp=sharing
- Aula 7 - https://docs.google.com/presentation/d/1BbQ31hbDJTjsOswL3urW8hZ6d4RWE8KOIhKmqsfNFlo/edit?usp=sharing

## Slides
- [2 - Introdução ao Android pt.2.pdf](Slides/2%20-%20Introdu%C3%A7%C3%A3o%20ao%20Android%20pt.2.pdf)

## Códigos
- [HelloToast](Códigos/HelloToast) - Challenging da Aula 1
- [Tela de login CardView e LinearLayout](Códigos/telaLoginIArTES) - Tela de login usando CardView e LinearLayout

## Projetos
- [Template do Projeto](https://docs.google.com/presentation/d/1ZbU1F5B4DNBWz3wevlcbb4H-XB7uD2siIZAlnq33pzA/edit?usp=sharing) - Template de apresentação do projeto

### Cronograma de Atividades
| Aula | Data | Atividade |
|------|------|-----------|
| 8 | 06/05 | Notifications e mapas, mockups dos projetos e acompanhamento |
| 9 | 08/05 | Implementação, apresentação parcial para quem estiver com o desenvolvimento mais maduro |
| Entrega Final | 11/05 | Entrega final do projeto (vídeo) |

### Temas dos Projetos

#### App de Saúde e Medicamentos
- **Equipe 1**: Nicolas e cia
- **Descrição**: Gerenciador de medicamentos e rotinas de saúde; este app deve conter o cadastro do medicamento junto com a hora para ser tomado, e a utilização do alarmManager para soar um alarme.
- **Funcionalidades**: Cadastro de medicamentos, alarmes, histórico
- **Tecnologias no App**: SQLite, RecyclerView, AlarmManager
- **Desafios específicos**: Uso do AlarmManager
- **Recursos**: 
  - [Agendamento de alarmes](https://developer.android.com/develop/background-work/services/alarms/schedule)
  - [Tutorial de AlarmManager](https://mubaraknative.medium.com/creating-a-alarm-using-alarmmanager-in-android-e27a4283d39f)

#### App de Livros
- **Equipe 2**: Camila e cia
- **Descrição**: Gestão de leituras e livros lidos (IMDB de livros); permitir ver livros avaliados e cadastrar a avaliação de um livro (lido ou na fila para leitura)
- **Funcionalidades**: Biblioteca pessoal, status de leitura, resenhas
- **Tecnologias no App**: Bottom Navigation, RecyclerView, SQLite, SharedPreferences (login salvo)
- **Desafios específicos**: Uso do bottom navigation e cadastro de resenhas e notas de livros (estrelas)

#### App de Eventos
- **Equipe 3**: Nelson e cia
- **Descrição**: Monitora eventos na cidade e visualiza eventos próximos a localização atual do usuário. O cadastro dos eventos pode ser mockup, com dados e localizações inseridos direto no banco.
- **Funcionalidades**: Gestão de eventos e visualização usando mapas
- **Tecnologias no App**: SQLite, cadastro de evento, uso de mapas
- **Desafios específicos**: Integração com Maps, marcadores no mapa, geolocalização

#### App de Tarefas a Fazer
- **Equipe 4**: Danielle e cia.
- **Descrição**: Gerenciador de tarefas com lembretes usando o NotificationManager
- **Funcionalidades**: Cadastrar tarefas e uma data de realização, prazo restante e notificação
- **Tecnologias no App**: NotificationManager, SQLite, RecyclerView
- **Desafios específicos**: Sistema de notificações agendadas
- **Recursos**:
  - [Documentação do NotificationManager](https://developer.android.com/reference/android/app/NotificationManager)
  - [Construção de notificações](https://developer-android-com.translate.goog/develop/ui/views/notifications/build-notification?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc)

#### App de Músicas
- **Equipe 5**: Elizangela e cia
- **Descrição**: Um app de músicas favoritas com um campo que indique a ordenação da música (estrelas ou nota da música, por exemplo). A lista de músicas deve retornar as músicas ordenadas descrescente por essa nota ou estrelas. A lista deve ser similar ao exemplo sunflower do slide 7. Ao clicar na fotinha da música, abra a música no spotify.
- **Funcionalidades**: Listar e cadastrar músicas favoritas com estrelas
- **Tecnologias no App**: RecyclerView com GridLayout, integração com Spotify
- **Desafios específicos**: GridLayout para exibição de itens, abrir o app do spotify ao clicar na música
- **Recursos**:
  - [Integração com Spotify via Intent](https://stackoverflow.com/questions/53969855/is-there-a-way-to-start-playing-music-on-spotify-with-an-intent)
  - [Como abrir o app do Spotify](https://community.spotify.com/t5/Android/How-to-lunch-Spotify-app-by-using-Intent-in-Android/td-p/4881574)

#### App de Oferta de Trabalho
- **Equipe 6**: Paulo
- **Descrição**: Um app onde um usuário oferta seus serviços e outro usuário demanda serviços como pedreiro, pintor, etc. O usuário fornecedor cadastra seus serviços e visualiza demandas pedidas. O usuário cliente vê a lista de serviços e escolhe um para fazer uma demanda.
- **Funcionalidades**: RecyclerView com filtro de busca e cadastro e visualização de serviços, RecyclerView de notificações de pedidos
- **Tecnologias no App**: SQLite, RecyclerView, sistema de busca e filtros no recyclerview

### Requisitos Comuns para Todos os Projetos
- Login de usuários
- Banco de dados SQLite (mínimo, mas podem usar outros como firebase, datastore, etc)
- RecyclerView para exibição de listas
- Interface de usuário intuitiva e atraente
- Splash Screen

## Plano de Ensino
- [Plano de Ensino IArTES.pdf](Plano_de_Ensino_IArTES.pdf)

## Referências
- [Android Developer Guides](https://developer.android.com/guide)

## Informações Úteis
- [Android Studio Download](https://developer.android.com/studio)
