package com.example.doublez;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SentenceAdapter extends RecyclerView.Adapter<SentenceAdapter.ViewHolder>
{
    private List<Sentence> sentenceList;
    private Activity activity;
    private VideoView videoView=null;
    private Uri rawUri;
    private MediaRecorder mediaRecorder=null;
    private File recordFile;
    private MediaPlayer mediaPlayer=null;
    private Uri uri;
    private ReadAACFileThread audioThread;

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        View sentenceView;
        TextView sentenceText;
        ImageView sentenceRec;
        ImageView sentencePlay;
        TextView scoreText;

        public ViewHolder (View view)
        {
            super(view);
            sentenceView=view;
            sentenceText=(TextView)view.findViewById(R.id.sentence_text);
            sentenceRec=(ImageView)view.findViewById(R.id.sentence_rec);
            sentencePlay=(ImageView)view.findViewById(R.id.sentence_play);
            scoreText=(TextView)view.findViewById(R.id.score_text);
        }
    }

    public SentenceAdapter(List<Sentence> sentenceList,Activity activity,VideoView videoview)
    {
        this.sentenceList=sentenceList;
        this.activity=activity;
        this.videoView =videoview;
    }

    @SuppressLint("ClickableViewAccessibility")
    public SentenceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sentence_item,parent,false);
        final SentenceAdapter.ViewHolder holder=new SentenceAdapter.ViewHolder(view);
        holder.sentenceText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //停止播放录音
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                }
                //停止录音
                if(mediaRecorder!=null)
                {
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    mediaRecorder = null;
                }

                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                // 各个Text的响应
                switch(sentence.getNum())
                {
                    case "1_1":
                        //播放视频
                        //rawUri= Uri.parse("http://t19p169001.imwork.net/doublez/a_1.mp4");
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_1);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_2":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_2);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_3":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_3);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_4":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_4);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_5":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_5);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_6":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_6);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "1_7":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_7);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_1":
                        //播放视频
                        rawUri= Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_1);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_2":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_2);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_3":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_3);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_4":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_4);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_5":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_5);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_6":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_6);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_7":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_7);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    case "2_8":
                        //播放视频
                        rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_8);
                        videoView.setVideoURI(rawUri);
                        videoView.start();
                        break;

                    default:
                }
            }
        });

        holder.sentenceRec.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                //按下J'enregiste
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    //颜色反转
                    holder.sentenceRec.setImageResource(R.mipmap.record_r);
                    //停止播放录音
                    if(mediaPlayer!=null)
                    {
                        mediaPlayer.stop();
                    }
                    //停止录音
                    if(mediaRecorder!=null)
                    {
                        mediaRecorder.stop();
                        mediaRecorder.release();
                        mediaRecorder = null;
                    }
                    switch(sentence.getNum())
                    {
                        case "1_1":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_1.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            //rawUri = Uri.parse("http://t19p169001.imwork.net/doublez/a_1s.mp4");
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_1s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_2":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_2.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_2s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();

                            break;

                        case "1_3":

                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_3.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_3s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();

                            break;

                        case "1_4":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_4.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_4s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_5":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_5.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_5s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_6":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_6.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_6s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "1_7":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "1_7.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_7s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "2_1":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_1.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_1s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "2_2":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_2.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_2s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();

                            break;

                        case "2_3":

                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_3.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_3s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();

                            break;

                        case "2_4":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_4.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_4s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "2_5":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_5.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_5s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "2_6":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_6.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_6s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "2_7":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_7.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_7s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        case "2_8":
                            //指向音频文件
                            recordFile=new File("/mnt/sdcard", "2_8.aac");
                            if (recordFile.exists())
                                recordFile.delete();
                            //开始录音
                            mediaRecorder=new MediaRecorder();
                            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                            mediaRecorder.setAudioSamplingRate(44100);
                            mediaRecorder.setAudioEncodingBitRate(96000);
                            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
                            try
                            {
                                mediaRecorder.prepare();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            mediaRecorder.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_8s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            break;

                        default:
                    }
                }

                //抬起录音按钮
                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    holder.sentenceRec.setImageResource(R.mipmap.record);
                    videoView.pause();
                    //停止播放录音
                    if(mediaPlayer!=null)
                    {
                        mediaPlayer.stop();
                    }
                    //停止录音
                    if(mediaRecorder!=null)
                    {
                        mediaRecorder.stop();
                        mediaRecorder.release();
                        mediaRecorder = null;
                    }
                    switch(sentence.getNum())
                    {
                        case "1_1":
                            sentenceList.get(0).thread("1_1.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "1_2":
                            sentenceList.get(1).thread("1_2.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "1_3":
                            sentenceList.get(2).thread("1_3.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "1_4":
                            sentenceList.get(3).thread("1_4.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "1_5":
                            sentenceList.get(4).thread("1_5.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "1_6":
                            sentenceList.get(5).thread("1_6.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "1_7":
                            sentenceList.get(6).thread("1_7.aac");
                            holder.scoreText.setText("已配音");
                            break;

                        case "2_1":
                            sentenceList.get(0).thread("2_1.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_2":
                            sentenceList.get(1).thread("2_2.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_3":
                            sentenceList.get(2).thread("2_3.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_4":
                            sentenceList.get(3).thread("2_4.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_5":
                            sentenceList.get(4).thread("2_5.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_6":
                            sentenceList.get(5).thread("2_6.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_7":
                            sentenceList.get(6).thread("2_7.aac");
                            holder.scoreText.setText("已配音");
                            break;
                        case "2_8":
                            sentenceList.get(7).thread("2_8.aac");
                            holder.scoreText.setText("已配音");
                            break;
                    }

                }
                return true;
            }


        });

        holder.sentencePlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position=holder.getAdapterPosition();
                Sentence sentence=sentenceList.get(position);
                //停止播放录音
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                }
                //停止录音
                if(mediaRecorder!=null)
                {
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    mediaRecorder = null;
                }

                switch(sentence.getNum())
                {
                    case "1_1":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_1.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            //rawUri = Uri.parse("http://t19p169001.imwork.net/doublez/a_1s.mp4");
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_1s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "1_2":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_2.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_2s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "1_3":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_3.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_3s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "1_4":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_4.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_4s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "1_5":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_5.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_5s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "1_6":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_6.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_6s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "1_7":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "1_7.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.a_7s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_1":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_1.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_1s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_2":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_2.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_2s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_3":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_3.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_3s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_4":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_4.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_4s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_5":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_5.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_5s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_6":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_6.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_6s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_7":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_7.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_7s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;

                    case "2_8":
                        //播放录音
                        recordFile=new File("/mnt/sdcard", "2_8.aac");  // 指向音频文件
                        if(!recordFile.exists())
                        {
                            Toast.makeText(activity,"录音不存在~",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            uri = Uri.fromFile(recordFile);
                            mediaPlayer = MediaPlayer.create(activity, uri);
                            mediaPlayer.start();
                            //播放视频
                            rawUri = Uri.parse("android.resource://" + "com.example.doublez" + "/" + R.raw.b_8s);
                            videoView.setVideoURI(rawUri);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mediaPlayer.stop();
                                }
                            });
                        }
                        break;
                }

            }
        });

        return holder;
    }

    public void onBindViewHolder(SentenceAdapter.ViewHolder holder, int position)
    {
        Sentence sentence=sentenceList.get(position);
        holder.sentenceText.setText(sentence.getText());
    }

    public int getItemCount()
    {
        return sentenceList.size();
    }

    public List<Sentence> returnList()
    {
        return sentenceList;
    }

    public void destroy()
    {
        //停止播放录音
        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
        }
        //停止录音
        if(mediaRecorder!=null)
        {
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }
}
