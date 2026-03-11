# SoundBridge

SoundBridge is a Java-based migration tool that extracts playlists from Spotify and finds matching songs on YouTube.

The project demonstrates how music metadata can be transferred across platforms by using APIs and data transformation pipelines.

## Features

- Extract playlists from Spotify
- Normalize and clean song titles
- Search YouTube for matching tracks
- Map songs to YouTube video IDs
- Generate a migration report with YouTube links
- Command-line interface for running tasks
- Logging and error handling

## System Architecture

```
Spotify API
    ↓
Playlist JSON
    ↓
Song Parser
    ↓
Title Normalization
    ↓
Export Playlist File
    ↓
Import Playlist File
    ↓
YouTube Search
    ↓
Video ID Extraction
    ↓
Migration Report
```

## Technologies Used

- Java
- Spotify Web API
- YouTube Data API v3
- JSON parsing with Jackson
- Git & GitHub for version control

## Project Structure

```
src/com/migrator/

auth        → Spotify authentication
spotify     → Spotify API integration
youtube     → YouTube search and matching
model       → Song and Playlist data models
export      → JSON export/import utilities
utils       → Logging and text utilities
```

## How to Run

### Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/soundbridge.git
```

### Compile the project

```bash
cd src
javac -cp ".;../lib/*" com/migrator/Main.java
```

### Run the program

```bash
java -cp ".;../lib/*" com.migrator.Main
```

Follow the menu prompts in the terminal.

## Example Output

Spotify song:
```
Believer - Imagine Dragons
```

Matched YouTube link:
```
https://www.youtube.com/watch?v=7wtfhZwyrcc
```

## Future Improvements

- Automatic playlist creation in YouTube Music
- Better song matching using duration and artist verification
- Web interface for easier usage

## Author

Vishnu Vardhan
