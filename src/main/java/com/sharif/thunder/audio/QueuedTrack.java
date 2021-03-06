/*
 *   Copyright 2019-2020 SharifPoetra
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.sharif.thunder.audio;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sharif.thunder.queue.Queueable;
import com.sharif.thunder.utils.FormatUtil;
import net.dv8tion.jda.api.entities.User;

public class QueuedTrack implements Queueable {
  private final AudioTrack track;

  public QueuedTrack(AudioTrack track, User owner) {
    this(track, owner.getIdLong());
  }

  public QueuedTrack(AudioTrack track, long owner) {
    this.track = track;
    this.track.setUserData(owner);
  }

  @Override
  public long getIdentifier() {
    return track.getUserData(Long.class);
  }

  public AudioTrack getTrack() {
    return track;
  }

  @Override
  public String toString() {
    return "`[" + FormatUtil.formatTime(track.getDuration()) + "]` **" + track.getInfo().title + "** - <@" + track.getUserData(Long.class) + ">";
  }
}
