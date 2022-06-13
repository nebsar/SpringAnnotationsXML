package deneme;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") //TODO: if not bean ID then default is tennisCoach!
@Component("denemeCoach")
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {

        return "Tennis 15 mins!";

    }
}
