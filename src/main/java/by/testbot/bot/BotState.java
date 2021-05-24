package by.testbot.bot;

public enum BotState {
    
    //region Main Menu
    MainMenu(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendFirstKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override 
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch(text) {

                case "Подобрать предложение":
                    botState = Settings; //TODO MY
                    break;
                default:
                    botState = MainMenu;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },
    
    PostponeMessage(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MainMenu;
        }
    },
    
    Managers(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendListOfManagersMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch(text) {
                case "Получить список менеджеров":
                    botState = ListOfManagers;
                    break;
                case "Добавить менеджера": 
                    botState = AddManager;
                    break;
                case "Удалить менеджера":
                    botState = DeleteManager;
                    break;
                case "Изменение привелегий":
                    botState = ChangeManagerPrivilegies;
                    break;
                case "Назад":
                    botState = MainMenu;
                    break;
                default:
                    botState = Managers;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },
    
    Clients(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendListOfClientsMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch(text) {
                case "Получить список клиентов и информацию о них":
                    botState = GetListOfClients;
                    break;
                case "Дополнительные операции с клиентами":
                    botState = AdditionalOperationsWithClients;
                    break;
                case "Назад":
                    botState = MainMenu;
                    break;
                default: 
                    botState = Clients;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },

    Report(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendReportMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "Отчет о работе менеджеров": 
                    botState = ReportAboutManagersWork;
                    break;
                case "Отчет о работе бота":
                    botState = ReportAbountBotWork;
                    break;
                case "Назад":
                    botState = MainMenu;
                    break;
                default:
                    botState = Report;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    }, 
    
    Integrations(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendIntegrationsMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "Добавление новой интеграции": 
                    botState = AddIntegration;
                    break;
                case "Удаление интергации":
                    botState = DeleteIntegration;
                    break;
                case "Новые интеграции":
                    botState = NewIntegrations;
                    break;
                case "Назад":
                    botState = MainMenu;
                    break;
                default:
                    botState = Integrations;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },
    
    Settings(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendSettingsMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "Уже брал":
                    botState = AlredyTaken;
                    break;
                case "Перейти":
                    botState = GoToLink;
                    break;
                case "Назад":
                    botState = MainMenu;
                    break;
                default:
                    botState = Settings;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },

    //endregion
    
    //region Managers
    ListOfManagers(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Managers;
        }
    },
    
    AddManager(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Managers;
        }
    }, 
    
    DeleteManager(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Managers;
        }
    }, 
    
    ChangeManagerPrivilegies(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Managers;
        }
    },


    //endregion
    
    //region Clients
    
    GetListOfClients(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Clients;
        }
    },
    
    AdditionalOperationsWithClients(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Clients;
        }
    }, 

    //endregion

    //region Report

    ReportAboutManagersWork(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Report;
        }
    },

    ReportAbountBotWork(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Report;
        }
    },

    //endregion

    //region Integrations

    AddIntegration(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Integrations;
        }
    },

    DeleteIntegration(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Integrations;
        }
    },

    NewIntegrations(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Integrations;
        }
    }, 

    //endregion

    //region Settings
    
    AlredyTaken(false) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return Settings;
        }
    }, 
    
    GoToLink(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendBotUsagePeriodMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch(text) {
                case "В чате(время обработки)":
                    botState = InChatBotUsingPeriod;
                    break;
                case "В ночное время":
                    botState = AtNightChatBotUsingPeriod;
                    break;
                case "Назад":
                    botState = Settings;
                    break;
                default: 
                    botState = GoToLink;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },

    //endregion

    //region SetBotUsingPeriod

    InChatBotUsingPeriod(true) {
        @Override
        public void enter(BotContext botContext) {
            
        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return GoToLink;
        }
    },

    AtNightChatBotUsingPeriod(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return GoToLink;
        }
    };

    //endregion

    private final Boolean isInputNeeded;

    BotState(Boolean isInputNeeded) {
        this.isInputNeeded = isInputNeeded;
    }

    public static BotState getInitialState() {
        return MainMenu;
    }

    public Boolean getIsInputNeeded() { return isInputNeeded; }

    public void handleInput(BotContext botContext) {}

    public abstract void enter(BotContext botContext);
    public abstract BotState nextState();
}
