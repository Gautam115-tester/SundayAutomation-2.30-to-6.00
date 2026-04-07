# Audio Vibe - Premium Audio Streaming App

A production-ready Flutter mobile application for streaming audio content (Audio Stories + Music), powered by a **Supabase PostgreSQL** database and a **Node.js/Express API** backend deployable on **Render.com**.

---

## Architecture Overview

```
Flutter App  -->  Backend API (Render/Node.js)  -->  Supabase PostgreSQL
                          |
                   (REST API endpoints)
```

| Layer | Technology |
|---|---|
| Mobile App | Flutter 3.x + Riverpod + Clean Architecture |
| Navigation | go_router (shell routes + deep-linking) |
| Audio Engine | just_audio + audio_service (background playback) |
| Backend | Node.js + Express + Prisma ORM |
| Database | Supabase PostgreSQL |
| Local Storage | Hive (NoSQL) + Flutter Secure Storage |
| Equalizer | Native Android AudioEffect via MethodChannel (Kotlin) |
| UI Framework | Material 3 Dark Theme + Google Fonts (Sora) |

---

## Features

### Audio Playback
- Background playback with Android media notification controls
- Lock-screen artwork, title, seek bar, and transport buttons
- **Bluetooth headset support**: play/pause, next, previous via hardware buttons
- Media session integration for Bluetooth devices and car audio systems
- Seek bar with unified timeline across multi-part files
- Playback speed control: 0.5x, 0.75x, 1x, 1.25x, 1.5x, 1.75x, 2x
- Auto-resume from saved position across app restarts
- Shuffle mode with queue reordering
- Skip forward 15s / rewind 10s buttons

### Bluetooth Support
- Full Bluetooth A2DP media control support
- Play/Pause toggle via Bluetooth headset button
- Next/Previous track via Bluetooth controls
- Media session metadata displayed on Bluetooth devices
- Headset hook single-tap handling
- AUDIO_BECOMING_NOISY handling (auto-pause on headset disconnect)
- Works with car Bluetooth systems, wireless earbuds, and speakers

### Native Android Equalizer
- **8 built-in presets**: Flat, Rock, Pop, Jazz, Classical, Bass Boost, Ultra Bass, Vocal, Treble
- Fully manual custom band adjustment with vertical sliders
- Real-time dB level display per band
- Frequency labels (Hz/kHz) for each band
- Master EQ on/off switch
- Persistent preset selection per session
- Native Android AudioEffect integration via Kotlin MethodChannel

### Music Features
- Album grid view with cover art
- Track listing with duration display
- **Loop modes**: None -> Repeat Song -> Repeat Album -> Repeat All
- Per-song favorite toggle (Hive-backed)
- Multi-part audio file support

### Audio Stories
- Series -> Episodes hierarchy
- Auto-play: next episode -> next series (continuous listening)
- Episode list with duration badges and multi-part indicators
- Per-episode favorite toggle

### Multi-Part Audio Merging
- Transparent multi-part file playback using ConcatenatingAudioSource
- Unified seek bar across all parts (user sees single continuous timeline)
- Lazy preparation for smooth streaming
- Multi-part download with automatic file merging
- Single merged file for offline playback
- Visual indicators for multi-part content

### Downloads & Offline
- Download progress indicators
- Multi-part download: downloads each part, merges into single file
- Delete individual downloads or "Clear All" with confirmation
- Storage usage display with formatted sizes (KB/MB/GB)
- Encrypted badge on downloaded items

### Search
- Full-text search across series, albums, episodes, and songs simultaneously
- Results grouped by type with type-specific icons
- Minimum 2-character query requirement with instant clear button

### Home Screen
- "Continue Listening" horizontal strip (last 10 played items)
- Featured banner with animated gradient decoration
- Audio Stories and Music Albums sections with shimmer loading skeletons
- "See All" navigation for both sections

### UI/UX
- Material 3 dark theme with custom deep purple + gold color palette
- Google Fonts (Sora) typography throughout
- Shimmer loading placeholders on all data screens
- Mini-player bar above bottom navigation — tap to open full player
- Full-screen player with slide-up animation
- Rotating album art during playback
- Responsive grid layouts for albums and series
- Custom slider theme matching app aesthetics

### Favorites
- Quick-toggle favorite on any episode or song
- Persistent favorites stored in Hive (offline-ready)
- Dedicated favorites screen

### Security
- FLAG_SECURE prevents screenshots in-app
- Cleartext traffic disabled (HTTPS only)
- Admin API endpoints protected by secret key

---

## Project Structure

```
audio_vibe_app/
├── lib/
│   ├── main.dart                          # App bootstrap, Hive init, AudioService init
│   ├── core/
│   │   ├── constants/app_constants.dart   # API URLs, box names, colors, skip durations
│   │   ├── theme/app_theme.dart           # Material 3 dark theme configuration
│   │   ├── services/supabase_service.dart # Supabase client + all data queries
│   │   ├── providers/providers.dart       # Riverpod providers (data + state)
│   │   ├── router/app_router.dart         # go_router configuration
│   │   └── widgets/app_shell.dart         # Bottom navigation + mini-player shell
│   ├── models/
│   │   ├── series.dart                    # Series data model
│   │   ├── episode.dart                   # Episode + EpisodePart models
│   │   ├── album.dart                     # Album data model
│   │   ├── song.dart                      # Song + SongPart models
│   │   └── playback_state.dart            # Playback state, enums, PlaybackItem
│   ├── services/
│   │   ├── audio_handler.dart             # AudioService handler (background playback)
│   │   ├── equalizer_service.dart         # Native equalizer via MethodChannel
│   │   ├── multi_part_service.dart        # Multi-part audio resolution
│   │   └── download_service.dart          # Download manager with merge support
│   ├── screens/
│   │   ├── home/home_screen.dart          # Home with featured banner, sections
│   │   ├── series/series_list_screen.dart # Grid of audio series
│   │   ├── series/series_detail_screen.dart # Episode listing
│   │   ├── music/music_screen.dart        # Album grid
│   │   ├── music/album_detail_screen.dart # Track listing
│   │   ├── player/player_screen.dart      # Full-screen player
│   │   ├── player/mini_player.dart        # Mini-player widget
│   │   ├── search/search_screen.dart      # Full-text search
│   │   ├── downloads/downloads_screen.dart # Download manager
│   │   └── favorites/favorites_screen.dart # Favorites list
│   └── widgets/
│       └── equalizer_sheet.dart           # Equalizer bottom sheet
├── android/
│   └── app/src/main/
│       ├── kotlin/com/superapp/audiovibe/
│       │   ├── MainActivity.kt            # Bluetooth key routing, equalizer channel
│       │   └── EqualizerManager.kt        # Native AudioEffect equalizer (Kotlin)
│       ├── AndroidManifest.xml            # Permissions, services, receivers
│       └── res/                           # Styles, drawables, launcher icons
├── backend/
│   ├── src/
│   │   ├── index.js                       # Express server setup
│   │   ├── routes/
│   │   │   ├── series.js                  # CRUD for series
│   │   │   ├── episodes.js                # Episodes + parts endpoints
│   │   │   ├── albums.js                  # CRUD for albums
│   │   │   ├── songs.js                   # Songs + parts endpoints
│   │   │   ├── search.js                  # Full-text search
│   │   │   └── admin.js                   # Admin management endpoints
│   │   └── middleware/
│   │       └── errorHandler.js            # Error handling middleware
│   ├── prisma/
│   │   └── schema.prisma                  # Database schema
│   ├── render.yaml                        # Render.com deployment config
│   ├── .env.example                       # Environment variables template
│   └── package.json
├── pubspec.yaml
└── README.md
```

---

## Setup Guide

### Step 1 — Set Up Supabase

1. Go to [supabase.com](https://supabase.com) -> create a free project
2. Copy your **Project URL** and **anon key** from Settings -> API
3. Copy the **Database URI** from Settings -> Database -> Connection String -> URI

### Step 2 — Deploy Backend to Render

1. Push the `backend/` folder to a GitHub repository
2. Go to [render.com](https://render.com) -> New -> Web Service
3. Connect your repo, set **Root Directory** to `backend`
4. Set **Build Command**: `npm install && npx prisma generate && npx prisma db push`
5. Set **Start Command**: `npm start`
6. Add environment variables:

| Variable | Value |
|---|---|
| `DATABASE_URL` | Supabase connection URI |
| `API_SECRET_KEY` | Random 32+ character string |
| `NODE_ENV` | `production` |

7. Deploy -> copy your Render URL

### Step 3 — Configure Flutter App

Edit `lib/core/constants/app_constants.dart`:

```dart
static const String supabaseUrl = 'https://your-project.supabase.co';
static const String supabaseAnonKey = 'your-anon-key';
static const String baseUrl = 'https://your-app.onrender.com/api';
```

### Step 4 — Add Content via Admin API

```bash
# Create a series
curl -X POST https://your-app.onrender.com/api/admin/series \
  -H "Content-Type: application/json" \
  -H "X-Admin-Key: YOUR_API_SECRET_KEY" \
  -d '{"title": "Karna Pishachini", "coverUrl": "https://example.com/cover.jpg"}'

# Create an episode
curl -X POST https://your-app.onrender.com/api/admin/episodes \
  -H "Content-Type: application/json" \
  -H "X-Admin-Key: YOUR_API_SECRET_KEY" \
  -d '{"seriesId": "SERIES_ID", "title": "Episode 1", "episodeNumber": 1, "durationSeconds": 659, "streamUrl": "https://your-audio-url.com/ep1.m4a"}'

# Add parts for multi-part episodes
curl -X POST https://your-app.onrender.com/api/admin/episodes/EPISODE_ID/parts \
  -H "Content-Type: application/json" \
  -H "X-Admin-Key: YOUR_API_SECRET_KEY" \
  -d '{"partNumber": 1, "durationSeconds": 467, "streamUrl": "https://your-audio-url.com/ep1_part1.m4a"}'
```

### Step 5 — Build and Run

```bash
flutter pub get
flutter run

# Release APK
flutter build apk --release

# App Bundle (Play Store)
flutter build appbundle --release
```

---

## Multi-Part Audio System

When an audio file is too large, it can be split into multiple parts. The app handles this transparently:

1. **Database**: Episodes/songs with multiple parts have `isMultiPart: true` and related part records
2. **Playback**: `MultiPartService` creates a `ConcatenatingAudioSource` from all part URLs
3. **Seek Bar**: Shows unified timeline across all parts — user sees one continuous audio
4. **Download**: All parts are downloaded and merged into a single file for offline playback

### Example
- Episode 13 "Karna Pishachini" has 2 parts:
  - Part 1: 7:47 duration
  - Part 2: 3:12 duration
  - Total displayed: 10:59 (seamless playback)

---

## API Endpoints

### Public Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/health` | Health check |
| GET | `/api/series` | List all series |
| GET | `/api/series/:id` | Get series with episodes |
| GET | `/api/episodes/series/:seriesId` | List episodes for series |
| GET | `/api/episodes/:id` | Get single episode |
| GET | `/api/episodes/:id/parts` | Get episode parts |
| GET | `/api/albums` | List all albums |
| GET | `/api/albums/:id` | Get album with songs |
| GET | `/api/songs/album/:albumId` | List songs for album |
| GET | `/api/songs/:id` | Get single song |
| GET | `/api/songs/:id/parts` | Get song parts |
| GET | `/api/search?q=query` | Full-text search |

### Admin Endpoints (requires X-Admin-Key header)
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/admin/stats` | Get content statistics |
| POST | `/api/admin/series` | Create series |
| POST | `/api/admin/episodes` | Create episode |
| POST | `/api/admin/episodes/:id/parts` | Add episode part |
| POST | `/api/admin/albums` | Create album |
| POST | `/api/admin/songs` | Create song |
| POST | `/api/admin/songs/:id/parts` | Add song part |
| GET | `/api/admin/logs` | View sync logs |

---

## Tech Stack Summary

| Feature | Technology |
|---|---|
| Framework | Flutter 3.x |
| State Management | Riverpod |
| Navigation | go_router |
| Audio Playback | just_audio + audio_service |
| Background Audio | audio_service (MediaBrowserService) |
| Bluetooth Controls | Android MediaSession + MediaButtonReceiver |
| Equalizer | Native Android AudioEffect (Kotlin) |
| Database | Supabase PostgreSQL + Prisma ORM |
| Backend | Node.js + Express |
| Local Storage | Hive + Flutter Secure Storage |
| Image Caching | cached_network_image |
| Typography | Google Fonts (Sora) |
| Animations | flutter_animate |
| Loading States | shimmer |
| Networking | Dio + supabase_flutter |
| Deployment | Render.com (backend) |

---

## Permissions Required

| Permission | Purpose |
|---|---|
| INTERNET | Network access for streaming |
| ACCESS_NETWORK_STATE | Check connectivity |
| WAKE_LOCK | Keep device awake during playback |
| FOREGROUND_SERVICE | Background audio service |
| FOREGROUND_SERVICE_MEDIA_PLAYBACK | Media playback notification |
| POST_NOTIFICATIONS | Show playback notification |
| BLUETOOTH | Bluetooth headset controls |
| BLUETOOTH_CONNECT | Connect to Bluetooth devices |
| MODIFY_AUDIO_SETTINGS | Equalizer audio effects |
| READ_MEDIA_AUDIO | Read device audio files |

---

## License

This project is proprietary. All rights reserved.
