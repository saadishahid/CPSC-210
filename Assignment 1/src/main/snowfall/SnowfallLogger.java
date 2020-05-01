package snowfall;

// Represents a snowfall logger
public class SnowfallLogger {
    public static final int THRESHOLD = 15;  // threshold snowfall amount in cms for a snow day
    int rec;
    int snowDay;
    double amount;
    // EFFECTS: constructs snowfall logger with no snowfall records
    public SnowfallLogger() {
        rec = 0;
        snowDay = 0;
        amount = 0.0;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: records a snowfall of amount centimetres; if amount is at least THRESHOLD cms, records a snow day
    public void addSnowfallRecord(int amount) {
    this.amount = this.amount +amount;
    if (amount >= THRESHOLD){
    snowDay++;
    rec++;
     } else {
        rec++;
    }
    }

    // MODIFIES: this
    // EFFECTS: resets the logger so that no snowfall records are recorded
    public void reset() {
        rec = 0;
        snowDay = 0;
        amount = 0;

    }

    // REQUIRES: getNumSnowfallRecords() > 0
    // EFFECTS: returns the average snowfall across all records added
    public double getAverageSnowfall() {
        return amount/rec;
    }

    // EFFECTS: returns the number of snowfall records added
    public int getNumSnowfallRecords() {
        return rec;
    }

    // EFFECTS: returns the number of snow days based on snowfall records added
    public int getNumSnowDays() {
        return snowDay;
    }
}
